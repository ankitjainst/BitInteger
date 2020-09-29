if test -f "$PWD/data_c.bin"; then
  rm $PWD/data_c.bin
  echo 'Deleted existing file '+"$PWD/data_c.bin"
fi
gcc src/main/c/write_integers.c
./a.out $PWD/data_c.bin
