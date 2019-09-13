module annot8.tutorial.writingprocessors {
  //Declare which modules we're using
  requires io.annot8.common.components;
  requires io.annot8.common.data;
  requires io.annot8.conventions;
  requires java.json.bind;

  //Declare which packages we're exposing to other modules
  exports io.annot8.examples.processors;
}