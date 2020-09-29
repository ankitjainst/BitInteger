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
	if ((fptr = fopen(path,"rb")) == NULL){
		printf("Error! opening file %s\n",path);
		exit(1);
	}
    printf("Read data from %s\n",path);
	fread(&num, sizeof(struct threeNum), 1, fptr); 
	printf("%d\n%d\n%d\n", num.n1, num.n2, num.n3);
	fclose(fptr); 

	return 0;
}
