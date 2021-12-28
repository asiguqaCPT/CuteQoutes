import 'package:app/api/quotes_service.dart';
import 'package:flutter/material.dart';
import 'package:app/components/components.dart';
import 'package:app/models/models.dart';

class QuotesScreen extends StatefulWidget {
  const QuotesScreen({Key? key}) : super(key: key);

  @override
  State<QuotesScreen> createState() => _QuotesScreenState();
}

class _QuotesScreenState extends State<QuotesScreen> {
  final qoutesService = QoutesService();

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      children: [
        SizedBox(
          height: 500,
          child: FutureBuilder(
            future: qoutesService.fetchQuotes(),
            builder: (context, AsyncSnapshot<QuotesList> snapshot) {
              if (snapshot.connectionState == ConnectionState.done) {
                return ListView.builder(
                    itemCount: snapshot.data?.quotes.length,
                    itemBuilder: (context, index) {
                  return QuoteCard(
                      quote: snapshot.data?.quotes[index].text ?? "$index",
                      author: snapshot.data?.quotes[index].id ?? "Null");
                });
              } else {
                return const Center(child: CircularProgressIndicator());
              }
            },
          ),
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.end,
          children: [
            FloatingActionButton(
              onPressed: () {},
              child: const Icon(Icons.add),
            ),
            const SizedBox(
              width: 20,
            )
          ],
        )
      ],
    );
  }
}
