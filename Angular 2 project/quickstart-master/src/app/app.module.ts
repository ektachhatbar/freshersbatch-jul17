import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http'; 

import { AppComponent }  from './app.component';
import { HomePageComponent }  from './component/HomeComponent/HomePageComponent.component';
import { FooterComponent }  from './component/HomeComponent/FooterComponent.component';
import { NavigationBarComponent }  from './component/HomeComponent/NavigationBarComponent.component';
import { MyAccountComponent }  from './component/HomeComponent/MyAccountComponent.component';
import { RegisterComponent }  from './component/HomeComponent/RegisterComponent.component';
import { UserProfileComponent }  from './component/HomeComponent/UserProfileComponent.component';

@NgModule({
  imports:      [ BrowserModule,FormsModule,HttpModule, RouterModule.forRoot([ {path: '', component: HomePageComponent}, {path: 'loginHome/:authToken/:userName', component: MyAccountComponent}, {path: 'register', component: RegisterComponent},{path: 'myProfile/:authToken/:userName', component: UserProfileComponent} ])],
  declarations: [ AppComponent,HomePageComponent,FooterComponent,NavigationBarComponent,MyAccountComponent,RegisterComponent,UserProfileComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
