import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-primary-button',
  imports: [],
  templateUrl: './primary-button.html',
  styleUrl: './primary-button.css'
})
export class PrimaryButton {
  private _textButtom: string = '';


  // Getters and Setters
  @Input()
  public set textButtom(value: string) { this._textButtom = value; }
  public get textButtom(): string { return this._textButtom; }
}
