import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';


import { AppComponent }  from './app.component';
import {advertisementForm} from './components/Advertisement_Form_Component/advertisementFormComponent.component';
import {advertisementTable} from './components/Advertisement_Table_Component/AdvertisementTableComponent.component';
import {SearchAd} from './pipes/search.pipe';
import {TemplateDriven} from './components/TemplateDrivenForm/TDFComponent.component';
import {ProductMdfFormComponent} from './components/ModelDrivenForm/MDFComponent.component';
import {ProductFormBuilderComponent} from './components/MDFwithFormBuilder/MDF_FormBuilderComponent.component';
import {ProductService} from './services/Product/AdvertisementService.service';
import {Home} from './components/home/HomeComponent.component';
import {Edit} from './components/EditAdvertisementComponent/EditComponent.component';

@NgModule({
  imports:      [ BrowserModule,FormsModule,ReactiveFormsModule,RouterModule.forRoot([ {path: '', component: Home}, {path: 'edit/:id', component: Edit} ])
],
  declarations: [ AppComponent, advertisementForm,advertisementTable,SearchAd,TemplateDriven,ProductMdfFormComponent,ProductFormBuilderComponent,Home,Edit],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
