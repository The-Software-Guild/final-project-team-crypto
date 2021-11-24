import { Component, OnInit } from '@angular/core';

import { CryptosService } from './cryptos.service'

import { Crypto } from './cryptos'
import { tick } from '@angular/core/testing';

@Component({
  selector: 'app-cryptos',
  templateUrl: './cryptos.component.html',
  providers: [CryptosService],
  styleUrls: ['./cryptos.component.css']
})
export class CryptosComponent implements OnInit {
  coin!: Crypto;
  btcPrice!: string;
  ethPrice!: string;
  bnbPrice!: string;
  adaPrice!: string;
  dogePrice!: string;

  constructor(private cService: CryptosService) { }

  ngOnInit(): void {
    this.getPrice('BTC');
    this.getPrice('ETH');
    this.getPrice('BNB');
    this.getPrice('ADA');
    this.getPrice('DOGE');
  }

  getPrice(ticker: string): void {
    this.cService.getAPIPrice(ticker).subscribe(price => {
      this.coin = price;

      switch (ticker){
        case 'BTC':
          this.btcPrice = this.coin['Realtime Currency Exchange Rate']['5. Exchange Rate'];
          this.cService.setPrice('BTC', this.btcPrice).subscribe(response =>{
            console.log(response)
          });
          break;
        case 'ETH':
          this.ethPrice = this.coin['Realtime Currency Exchange Rate']['5. Exchange Rate'];
          this.cService.setPrice('ETH', this.ethPrice).subscribe(response =>{
            console.log(response)
          });
          break;
        case 'BNB':
          this.bnbPrice = this.coin['Realtime Currency Exchange Rate']['5. Exchange Rate'];
          this.cService.setPrice('BNB', this.bnbPrice).subscribe(response =>{
            console.log(response)
          });
          break;
        case 'ADA':
          this.adaPrice = this.coin['Realtime Currency Exchange Rate']['5. Exchange Rate'];
          this.cService.setPrice('ADA', this.adaPrice).subscribe(response =>{
            console.log(response)
          });
          break;
        case 'DOGE':
          this.dogePrice = this.coin['Realtime Currency Exchange Rate']['5. Exchange Rate'];
          this.cService.setPrice('DOGE', this.dogePrice).subscribe(response =>{
            console.log(response)
          });
          break;
        default:
          break;
      }

    },
    error => {
      
        this.cService.getServerPrice(ticker).subscribe(coin => {
          switch (ticker){
            case 'BTC':
              this.btcPrice = coin.price;
              
              break;
            case 'ETH':
              this.ethPrice = coin.price;
              break;
            case 'BNB':
              this.bnbPrice = coin.price;
              break;
            case 'ADA':
              this.adaPrice = coin.price;
              break;
            case 'DOGE':
              this.dogePrice = coin.price;
              break;
            default:
              console.log(error);
              break;
          }
        })
    });
  }

}
