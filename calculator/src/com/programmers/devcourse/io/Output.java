package com.programmers.devcourse.io;

import java.io.IOException;
import java.util.Map;

public interface Output {


  void sendAllResults(Map<?, ? extends Number> map);


  void close() throws IOException;

  void sendMessage(String s);
}
