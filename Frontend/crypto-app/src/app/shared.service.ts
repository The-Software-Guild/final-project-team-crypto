import { Injectable, Component, Input, Output, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  @Output() fire: EventEmitter<any> = new EventEmitter();

   constructor() {
     console.log('shared service started');
   }

   login() {
    console.log('logged in'); 
     this.fire.emit(true);
   }

   logout(){
    console.log('logged out'); 
    this.fire.emit(false);
   }

   getEmittedValue() {
     return this.fire;
   }
}
