import 'package:flutter/material.dart';

class QuoteCard extends StatelessWidget {
  final String quote;
  final String author;

  const QuoteCard({Key? key, required this.quote, required this.author})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
        padding: const EdgeInsets.fromLTRB(10, 10, 10, 0),
        child: Container(
          padding: const EdgeInsets.all(10),
          decoration: const BoxDecoration(
              color: Colors.green,
              borderRadius: BorderRadius.all(Radius.circular(10))),
          child: Column(
            children: [
              Text(
                quote,
                style: const TextStyle(
                    color: Colors.white,
                    fontWeight: FontWeight.bold,
                    fontSize: 20),
              ),
              const SizedBox(
                height: 5,
              ),
              Text(
                author,
                style: const TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.w800,
                    color: Colors.white),
              )
            ],
          ),
        ));
  }
}
