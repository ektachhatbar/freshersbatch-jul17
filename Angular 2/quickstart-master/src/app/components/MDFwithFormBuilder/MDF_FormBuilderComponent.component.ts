import { Component} from '@angular/core';

import { ReactiveFormsModule, FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({ 
    selector: 'form-builder', 
    templateUrl: './MDFwithFormBuilder.html'
}) 
export class ProductFormBuilderComponent 
{ productForm: FormGroup; 
    constructor(private formBuilder: FormBuilder) { 
        this.productForm = this.formBuilder.group({ 
            name: ['Ekta', [Validators.required, Validators.minLength(3), Validators.maxLength(8)]], quantity: [], price: [] 
        }); 
    } 
}