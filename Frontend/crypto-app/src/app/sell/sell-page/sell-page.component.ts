import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { OrderService } from 'src/app/auth/order.service';
import { CryptosService } from 'src/app/cryptolist/cryptos/cryptos.service';
import { SharedService } from 'src/app/shared.service';
import {Crypto} from '../../cryptolist/cryptos/cryptos';

@Component({
  selector: 'app-sell-page',
  templateUrl: './sell-page.component.html',
  styleUrls: ['./sell-page.component.css']
})
export class SellPageComponent implements OnInit {
  selected: string = '';
  coinPrice: string = "0";
  total:number = 0;
  coin!: Crypto;

  btcPrice!: string;
  ethPrice!: string;
  bnbPrice!: string;
  adaPrice!: string;
  dogePrice!: string;

  sellForm: FormGroup;


  constructor(
    private orderService: OrderService,
    private formBuilder: FormBuilder,
    private router: Router,
    private cService: CryptosService,
    private ss: SharedService
  ) { this.ss = ss; }

  ngOnInit(): void {
    this.ss.login();
    this.sellForm = new FormGroup({
      ticker: new FormControl(null, [Validators.required]),
      amount: new FormControl(null, [Validators.required])
    })
    this.getPrice('BTC');
    this.getPrice('ETH');
    this.getPrice('BNB');
    this.getPrice('ADA');
    this.getPrice('DOGE');
  }

  onSubmit() {
    if(this.sellForm.invalid) {
      return;
    }
    console.log(this.sellForm);
  }

  selectChangeHandler (event: any) {
    //update the ui
    this.selected = event.target.value;
    switch(this.selected){
      case "1": 
        this.coinPrice = this.btcPrice;
        break;
      case "2": 
        this.coinPrice = this.ethPrice;
        break;
      case "3": 
        this.coinPrice = this.bnbPrice;
        break;
      case "4": 
        this.coinPrice = this.adaPrice;
        break;
      case "5": 
        this.coinPrice = this.dogePrice;
        break;
      default:
        this.coinPrice = "0";
        break;
    }
  }

  moneyChange (event: any) {
    //update the ui
    const amount:number = event.target.value;
    const curPrice:number = +this.coinPrice
    this.total = amount * curPrice;
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
