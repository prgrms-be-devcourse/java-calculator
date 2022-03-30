package com.programmers.devcourse.io;

import java.io.IOException;

public interface Input {

  int getMenuSelection() throws IOException;

  String getExpression() throws IOException;


  void close() throws IOException;
}


