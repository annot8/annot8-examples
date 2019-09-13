# Writing Processors

This project demonstrates a simple processor which extracts numbers from text.
The three classes required to build a processor are:

* Numbers - this is the descriptor for the processor, which describes what it is capable of and how to build it
* NumbersProcessor - this is the actual processor, which does the processing of the content
* NumbersSettings - this is the configuration for the processor

All three classes are required to create a processor in Annot8 (and equivalents if you wish to create a source), although in many cases the settings class may be the `NoSettings` helper class.

The files are all fully commented, and tests are provided. 