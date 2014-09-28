import java.util.*;
import java.io.*;

PImage p0;
PImage p1;
PImage p2;
PImage p3;
PImage p4;
PImage p5;
PImage p6;
PImage p7;
PImage p8;
PImage p9;
PImage p10;
PImage p11;
PVector c0 = new PVector(250, 240, 230);
PVector c1 = new PVector(170, 20, 0);
PVector c2 = new PVector(0, 100, 50);
PVector c3 = new PVector(45, 15, 40);
PVector c4 = new PVector(200, 180, 10);
PVector c5 = new PVector(0, 30, 100);
PVector c6 = new PVector(230, 210, 130);
PVector c7 = new PVector(0, 110, 170);
PVector c8 = new PVector(200, 70, 20);
PVector c9 = new PVector(80, 160, 20);
PVector c10 = new PVector(240, 130, 160);
PVector c11 = new PVector(150, 150, 140);

int[][] arr = new int[12][10];


void setup(){
  size(500, 500);
  p0 = loadImage("0.jpg");
  p1 = loadImage("1.jpg");
  p2 = loadImage("2.jpg");
  p3 = loadImage("3.jpg");
  p4 = loadImage("4.jpg");
  p5 = loadImage("5.jpg");
  p6 = loadImage("6.jpg");
  p7 = loadImage("7.jpg");
  p8 = loadImage("8.jpg");
  p9 = loadImage("9.jpg");
  p10 = loadImage("10.jpg");
  p11 = loadImage("11.jpg");

  PImage[] a = new PImage[12];
  a[0] = p0;
  a[1] = p1;
  a[2] = p2;
  a[3] = p3;
  a[4] = p4;
  a[5] = p5;
  a[6] = p6;
  a[7] = p7;
  a[8] = p8;
  a[9] = p9;
  a[10] = p10;
  a[11] = p11;

  for (int i = 0; i < 12; i++) {
    a[i].resize(500, 500);
    arr[i][0] = findColor(a[i], 250, 80);
    arr[i][1] = findColor(a[i], 325, 160);
    arr[i][2] = findColor(a[i], 430, 220);
    arr[i][3] = findColor(a[i], 380, 310);
    arr[i][4] = findColor(a[i], 360, 430);
    arr[i][5] = findColor(a[i], 250, 410);
    arr[i][6] = findColor(a[i], 130, 420);
    arr[i][7] = findColor(a[i], 115, 310);
    arr[i][8] = findColor(a[i], 75, 200);
    arr[i][9] = findColor(a[i], 175, 150);
  }
  //println(Arrays.deepToString(arr));
  try{
  output();
  }
  catch (Exception e){
    System.out.println("HI");
  }
  println("DONE");
  exit();
}

void output()throws IOException {
  PrintWriter out = createWriter("minx.txt");
  for (int i = 0; i < 12; i++) {
    for (int j = 0; j < 10; j++) {
      out.print(arr[i][j]+ " ");
    }
    out.println();
  } 
  out.close();
}


int findColor(PImage p, int x, int y) {
  p.loadPixels();
  int r;
  int g;
  int b;
  color co = p.pixels[y*500+x];
  r = co >> 16 & 0xFF;
  g = co >> 8 & 0xFF;
  b = co & 0xFF;
  PVector c = new PVector(r, g, b);
  int ans = 0;
  float min = PVector.sub(c, c0).mag();
  if (PVector.sub(c, c1).mag() < min) {
    min = PVector.sub(c, c1).mag();
    ans = 1;
  }
  if (PVector.sub(c, c2).mag() < min) {
    min = PVector.sub(c, c2).mag();
    ans = 2;
  }
  if (PVector.sub(c, c3).mag() < min) {
    min = PVector.sub(c, c3).mag();
    ans = 3;
  }
  if (PVector.sub(c, c4).mag() < min) {
    min = PVector.sub(c, c4).mag();
    ans = 4;
  }
  if (PVector.sub(c, c5).mag() < min) {
    min = PVector.sub(c, c5).mag();
    ans = 5;
  }
  if (PVector.sub(c, c6).mag() < min) {
    min = PVector.sub(c, c6).mag();
    ans = 6;
  }
  if (PVector.sub(c, c7).mag() < min) {
    min = PVector.sub(c, c7).mag();
    ans = 7;
  }
  if (PVector.sub(c, c8).mag() < min) {
    min = PVector.sub(c, c8).mag();
    ans = 8;
  }
  if (PVector.sub(c, c9).mag() < min) {
    min = PVector.sub(c, c9).mag();
    ans = 9;
  }
  if (PVector.sub(c, c10).mag() < min) {
    min = PVector.sub(c, c10).mag();
    ans = 10;
  }
  if (PVector.sub(c, c11).mag() < min) {
    min = PVector.sub(c, c11).mag();
    ans = 11;
  }

  return ans;
}

