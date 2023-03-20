import 'package:danim/view_models/post_view_model.dart';
import 'package:danim/view_models/timeline_detail_view_model.dart';
import 'package:danim/views/app_bar.dart';
import 'package:danim/views/custom_expansion_tile.dart';
import 'package:danim/views/post_detail.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:timeline_tile/timeline_tile.dart';

import 'bottom_navigation.dart';
import 'camera_floating_action_button.dart';

class TimelineDetail extends StatelessWidget {
  const TimelineDetail({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: const MyCustomAppBar(key: Key("appbar")),
      body: Consumer<TimelineDetailViewModel>(
          builder: (context, viewModel, child) {
        return ListView.builder(
          padding: EdgeInsets.zero,
          itemCount: 3, // Number of nations
          itemBuilder: (BuildContext context, int index) {
            return CustomExpansionTile(
              title: Text('Nation $index'),
              trailing: null,
              leading: SizedBox(
                width: 60,
                height: 60,
                child: TimelineTile(
                  alignment: TimelineAlign.manual,
                  isFirst: index == 0,
                  lineXY: 0.1,
                  // isFirst: true,
                  indicatorStyle: const IndicatorStyle(
                    width: 30,
                    color: Colors.purple,
                  ),
                  endChild: Container(
                    padding: const EdgeInsets.all(8),
                  ),
                ),
              ),
              children: [
                CustomExpansionTile(
                  title: const Text('city A'),
                  leading: SizedBox(
                    width: 60,
                    height: 60,
                    child: TimelineTile(
                      indicatorStyle: const IndicatorStyle(
                          width: 20,
                          color: Colors.lightBlueAccent,
                          padding: EdgeInsets.only(left: 5)),
                      endChild: Container(
                        padding: const EdgeInsets.all(8),
                      ),
                    ),
                  ),
                  children: [
                    PostDetail(
                        viewModel: PostViewModel(viewModel.timeline!.post[0]))
                  ],
                ),
                CustomExpansionTile(
                  title: const Text('city B'),
                  leading: SizedBox(
                    width: 60,
                    height: 60,
                    child: TimelineTile(
                      indicatorStyle: const IndicatorStyle(
                        width: 20,
                        color: Colors.lightBlueAccent,
                        padding: EdgeInsets.only(left: 5),
                      ),
                      endChild: Container(
                        padding: const EdgeInsets.all(8),
                      ),
                    ),
                  ),
                ),
              ],
            );
          },
        );
      }),
      floatingActionButton: const CameraFloatingActionButton(),
      floatingActionButtonLocation: FloatingActionButtonLocation.centerDocked,
      bottomNavigationBar: const CustomBottomNavigationBar(),
    );
  }
}
