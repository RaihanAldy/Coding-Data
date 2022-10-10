#include <iostream>
#include <conio.h>
#include <stdlib.h>
using namespace std;
#define MAX 8

struct Antrian{
    int data[MAX];
    int head=-1;
    int tail=-1;
};

Antrian antre;
void create();
bool isEmpty();
bool isFull();
void Clear();
void enqueue(int);
int dequeue();
void tampil();

int main()
{
        int pilih,urut,p=1;
        do{
            system("cls");
            cout << "1. Tambah Antrian "<<endl;
            cout << "2. Panggil Antrian "<<endl;
            cout << "3. Lihat daftar Antrian "<<endl;
            cout << "4. Clear Antrian "<<endl;
            cout << "5. Exit "<<endl;
            cin >> pilih;
            cout << "\n\n";

            if(pilih == 1){
                if(isFull()){
                   cout<< "Antrian penuh";
                   }
                else{
                   urut = p;
                   enqueue(urut);
                cout << antre.tail << " Antrian " << endl;
                p++;
                }
            }
            else if(pilih == 2){
            cout << "No. Antri : " << antre.data[antre.head] ;
            dequeue();
            cout << "Silahkan Dipanggil !" << endl;
        }
        else if(pilih == 3){
            tampil();
        }
        else if(pilih == 4){
            Clear();
        }
        else if(pilih == 5){
        }
        else{
            cout << "Masukan anda salah ! \n"<< endl;
        }
        getch();
    }
    while(pilih!=5);
}

void create(){
    antre.head = antre.tail = -1;
}

bool isEmpty(){
    if(antre.tail == -1){
        return true;
    }else{
        return false;
    }
}

bool isFull(){
    if(antre.tail == MAX-1){
        return true;
    }else{
        return false;
    }
}

void enqueue(int data){
    if(isEmpty() == 1){
        antre.head = antre.tail = 0;
        antre.data[antre.tail] = data;
    }else{
        antre.tail++;
    }
    antre.data[antre.tail] = data;
    cout<< data << " dimasukkan ke antrian ";
}

int dequeue(){
    int i;
    int e = antre.data[antre.head];

    if(isEmpty()){
        cout<< "Antrian Kosong";
        getch();
    }else{
    for(i = antre.head;i <= antre.tail;i++){
        antre.data[i] = antre.data[i+1];
    }
    antre.tail--;
    }
    return e;
}

void Clear(){
    antre.head = antre.tail = -1;
    cout << "Data Dikosongkan!";
}

void tampil(){
    if(isEmpty()){
        cout<<"Data kosong";
    }
    else{
        system("cls");
        for(int i = antre.head;i <= antre.tail;i++){
            cout<<antre.data[i];
        }
    }
}
