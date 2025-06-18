//
//  Input.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 18/06/25.
//

import Foundation
import UIKit

public class Input: UIView {
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.font = Typographies.label
        label.textColor = Colors.gray_800
        
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private let textField: UITextField = {
        let textField = UITextField()
        textField.font = Typographies.input
        textField.textColor = Colors.gray_800
        textField.borderStyle = .roundedRect
        textField.backgroundColor = Colors.gray_100
        textField.layer.cornerRadius = 8
        textField.layer.masksToBounds = true
        textField.layer.borderWidth = 1
        textField.layer.borderColor = Colors.gray_400.cgColor
        
        textField.translatesAutoresizingMaskIntoConstraints = false
        return textField
    }()
    
    init(title: String, placeholder: String) {
        super.init(frame: .zero)
        self.translatesAutoresizingMaskIntoConstraints = false
        
        self.titleLabel.text = title
        self.textField.placeholder = placeholder
        self.configurePlaceholder(placeholder: placeholder)
        
        self.setupView()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func configurePlaceholder(placeholder: String) -> Void {
        self.textField.attributedPlaceholder = NSAttributedString(string: placeholder,
                                                                  attributes: [NSAttributedString.Key.foregroundColor: Colors.gray_700])
    }
    
    private func setupView() -> Void {
        self.addSubview(titleLabel)
        self.addSubview(textField)
        
        self.setupConstraints()
    }
    
    private func setupConstraints() -> Void {
        NSLayoutConstraint.activate([
            self.titleLabel.topAnchor.constraint(equalTo: self.topAnchor),
            self.titleLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            
            self.textField.topAnchor.constraint(equalTo: self.titleLabel.bottomAnchor, constant: Metrics.s3),
            self.textField.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.textField.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            self.textField.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.textField.heightAnchor.constraint(equalToConstant: Metrics.inputSize),
        ])
    }
    
    internal func getText() -> String {
        return self.textField.text ?? ""
    }
}
