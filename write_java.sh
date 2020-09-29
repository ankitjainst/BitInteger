if test -f "$PWD/data_java.bin"; then
  rm $PWD/data_java.bin
  echo 'Deleted existing file '+"$PWD/data_java.bin"
fi

gradle build
java -jar build/libs/BitInteger.jar $PWD/data_java.bin write
