import 'package:danim/view_models/my_timeline_list_view_model.dart';
import 'package:danim/views/timeline_list_item.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class MyTimeLineListView extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ChangeNotifierProvider<MyTimeLineListViewModel>(
          create: (_) => MyTimeLineListViewModel(),
          child: Consumer<MyTimeLineListViewModel>(
              builder: (context, viewModel, child) => Column(
                    children: [
                      Container(),
                      ListView.builder(
                          itemCount: viewModel.mytimelineList.length,
                          itemBuilder: (context, index) {
                            return TimelineListItem(
                                viewModel.mytimelineList[index]);
                          }),
                    ],
                  ))),
    );
  }
}
