import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

export interface DialogData {
  animal: string;
  name: string;
}

@Component({
  selector: 'app-text',
  templateUrl: './text.component.html',
  styleUrls: ['./text.component.css']
})
export class TextComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<TextComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) { }

    ngOnInit() {
      setTimeout(() => this.dialogRef.close(),2000)
    }

}