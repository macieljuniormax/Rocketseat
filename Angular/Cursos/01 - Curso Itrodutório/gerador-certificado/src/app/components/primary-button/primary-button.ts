import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-primary-button',
  imports: [CommonModule],
  templateUrl: './primary-button.html',
  styleUrl: './primary-button.css'
})
export class PrimaryButton {
  private _textButton: string = '';
  private _disabled: boolean = false;


  // Getters and Setters
  @Input()
  public set textButton(value: string) { this._textButton = value; }
  public get textButton(): string { return this._textButton; }
  @Input()
  public set disabled(value: boolean) { this._disabled = value; }
  public get disabled(): boolean { return this._disabled; }
}
