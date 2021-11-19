import { Component, OnInit } from '@angular/core';

import { Crypto } from './cryptos';
import { CryptosService } from './cryptos.service'

@Component({
  selector: 'app-cryptos',
  templateUrl: './cryptos.component.html',
  providers: [CryptosService],
  styleUrls: ['./cryptos.component.css']
})
export class CryptosComponent implements OnInit {
  cryptos: Crypto[] = [];

  constructor(private cService: CryptosService) { }

  ngOnInit(): void {
    this.getBTC();
  }

  getBTC(): void {
    this.cService.getBTC().subscribe(cryptos => (this.cryptos = cryptos));
  }

}
