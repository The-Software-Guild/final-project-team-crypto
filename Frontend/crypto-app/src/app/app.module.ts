import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { HomeModule } from './home/home.module';
import { AccountModule } from './account/account.module';
import { AboutusModule } from './aboutus/aboutus.module';
import { CryptolistRoutingModule } from './cryptolist/cryptolist-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { LoginModule} from './login/login.module';
import {SignupModule} from './signup/signup.module';
import { MatButtonModule } from '@angular/material/button';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    HomeModule,
    AccountModule,
    AboutusModule,
    CryptolistRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    LoginModule,
    SignupModule



  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
