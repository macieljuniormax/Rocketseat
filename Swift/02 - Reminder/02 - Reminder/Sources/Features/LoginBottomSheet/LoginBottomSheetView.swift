//
//  LoginBottonSheetView.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 15/06/25.
//

import Foundation
import UIKit

class LoginBottomSheetView: UIView {
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.text = "login.lable.title".localized
        label.font = Typographies.subheading
        label.isUserInteractionEnabled = true
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private let handleArea: UIView = {
        let view = UIView()
        view.backgroundColor = Colors.gray_800
        view.layer.cornerRadius = Metrics.tiny
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private let emailTextFieldLabel: UILabel = {
        let label = UILabel()
        label.text = "login.lable.emailTextField".localized
        label.font = Typographies.label
        label.isUserInteractionEnabled = true
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private let emailTextField: UITextField = {
        let text = UITextField()
        text.placeholder = "login.placeholder.email".localized
        text.font = Typographies.input
        text.borderStyle = .roundedRect
        text.translatesAutoresizingMaskIntoConstraints = false
        return text
    }()
    
    private let passwordTextFieldLabel: UILabel = {
        let label = UILabel()
        label.text = "login.lable.passwordTextField".localized
        label.font = Typographies.label
        label.isUserInteractionEnabled = true
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private let passwordTextField: UITextField = {
        let text = UITextField()
        text.placeholder = "login.placeholder.password".localized
        text.font = Typographies.input
        text.borderStyle = .roundedRect
        text.isSecureTextEntry = true
        text.translatesAutoresizingMaskIntoConstraints = false
        return text
    }()
    
    private let loginButton: UIButton = {
        let button = UIButton(type: UIButton.ButtonType.system)
        button.setTitle("login.button.title".localized, for: UIControl.State.normal)
        button.setTitleColor(Colors.gray_100, for: UIControl.State.normal)
        button.titleLabel?.font = Typographies.subheading
//        button.tintColor = Colors.gray_100
        button.backgroundColor = Colors.red_primary
        button.layer.cornerRadius = Metrics.large
        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }()
        
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupUI()
        
        let exampleGesture = UITapGestureRecognizer(target: self, action: #selector(exampleTaped))
        self.titleLabel.addGestureRecognizer(exampleGesture)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    @objc private func exampleTaped() -> Void {
        print("Clicou na label")
    }
    
    private func setupUI() -> Void {
        self.backgroundColor = Colors.gray_100
        self.layer.cornerRadius = Metrics.small
        
//        self.addSubview(self.handleArea)
        self.addSubview(self.titleLabel)
        self.addSubview(self.emailTextFieldLabel)
        self.addSubview(self.emailTextField)
        self.addSubview(self.passwordTextFieldLabel)
        self.addSubview(self.passwordTextField)
        self.addSubview(self.loginButton)
        
        setupConstraints()
    }
    
    private func setupConstraints() -> Void {
        NSLayoutConstraint.activate([
//            self.handleArea.topAnchor.constraint(equalTo: self.topAnchor, constant: Metrics.small),
//            self.handleArea.centerXAnchor.constraint(equalTo: self.centerXAnchor),
//            self.handleArea.widthAnchor.constraint(equalToConstant: 40),
//            self.handleArea.heightAnchor.constraint(equalToConstant: 6),
  
            self.titleLabel.topAnchor.constraint(equalTo: self.topAnchor, constant: Metrics.huge),
            self.titleLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.medium),
            
            self.emailTextFieldLabel.topAnchor.constraint(equalTo: self.titleLabel.bottomAnchor, constant: Metrics.small + Metrics.large),
            self.emailTextFieldLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.medium),
            
            self.emailTextField.topAnchor.constraint(equalTo: self.emailTextFieldLabel.bottomAnchor, constant: Metrics.small),
            self.emailTextField.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.medium),
            self.emailTextField.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -Metrics.medium),
            self.emailTextField.heightAnchor.constraint(equalToConstant: Metrics.inputSize),
            
            self.passwordTextFieldLabel.topAnchor.constraint(equalTo: self.emailTextField.bottomAnchor, constant: Metrics.tiny + Metrics.small),
            self.passwordTextFieldLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.medium),
            
            self.passwordTextField.topAnchor.constraint(equalTo: self.passwordTextFieldLabel.bottomAnchor, constant: Metrics.small),
            self.passwordTextField.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.medium),
            self.passwordTextField.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -Metrics.medium),
            self.passwordTextField.heightAnchor.constraint(equalToConstant: Metrics.inputSize),
      
            
            self.loginButton.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.medium),
            self.loginButton.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -Metrics.medium),
            self.loginButton.bottomAnchor.constraint(equalTo: self.bottomAnchor, constant: -Metrics.huge),
            self.loginButton.heightAnchor.constraint(equalToConstant: Metrics.buttomSize)
        ])
    }
}
