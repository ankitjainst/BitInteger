#include <stdio.h>
#include <stdlib.h>

struct threeNum
{
   int n1, n2, n3;
};

struct threeNum num;
FILE *fptr;
char *path;

int main(int argc, char** argv)
{
	int n;
	if(argc < 2){
		printf("Please provide path of data");
		return 1;
	}else
	{
		path = argv[1];
	}
	if ((fptr = fopen(path,"wb")) == NULL){
		printf("Error! opening file %s\n",path);
		exit(1);
	}

    printf("Integers are of size %li\n",sizeof(int));

	num.n1 = 13;
	num.n2 = -220;
	num.n3 = 515;
	printf("Writing %i, %i, %i to %s\n",num.n1, num.n2, num.n3, path);
	fwrite(&num, sizeof(struct threeNum), 1, fptr);
	fclose(fptr);
	return 0;
}
