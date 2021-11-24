import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SharedService } from './shared.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'crypto-app';

  logged: boolean;
  ss: SharedService;
  subscription: any;

  constructor(ss: SharedService, private router: Router,) {
    this.logged = false;
    this.ss = ss;
  }

  ngOnInit() {
    this.subscription = this.ss.getEmittedValue()
      .subscribe(item => this.logged=item);
  }

  logOut(){
    this.ss.logout();
    this.router.navigate(['home'])
  }
}
