import { Component} from '@angular/core';
import { FormGroup } from "@angular/forms";
import { FormControl , Validators} from "@angular/forms";

@Component({
    selector: 'mdf-form', 
    templateUrl: './ModelDrivenForm.html' 
}) 
    export class ProductMdfFormComponent { 
        productForm = new FormGroup({ 
            name: new FormControl(null, [Validators.required, Validators.minLength(3), 
Validators.maxLength(8)]), 
            quantity: new FormControl(9), 
            price: new FormControl() 
        });
        onSubmit() { 
            console.log(this.productForm.value);
        } 
    }