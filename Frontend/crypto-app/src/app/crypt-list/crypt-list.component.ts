import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-crypt-list',
  templateUrl: './crypt-list.component.html',
  styleUrls: ['./crypt-list.component.css']
})
export class CryptListComponent implements OnInit {
  @Input() pages = [];
  constructor() { }

  ngOnInit(): void {
  }

}
