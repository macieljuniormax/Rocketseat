import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-secondary-button',
  imports: [CommonModule],
  templateUrl: './secondary-button.html',
  styleUrl: './secondary-button.css'
})
export class SecondaryButton {
  private _textButton: string = '';
  private _phClass: string = '';
  private _disabled: boolean = false;



  // Getters and Setters
  @Input()
  public set textButton(value: string) { this._textButton = value; }
  public get textButton(): string { return this._textButton; }
  @Input()
  public set phClass(value: string) { this._phClass = value; }
  public get phClass(): string { return this._phClass; }
  @Input()
  public set disabled(value: boolean) { this._disabled = value; }
  public get disabled(): boolean { return this._disabled; }
}
