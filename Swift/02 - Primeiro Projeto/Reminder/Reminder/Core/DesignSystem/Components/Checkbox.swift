//
//  Checkbox.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 18/06/25.
//

import Foundation
import UIKit

class Checkbox: UIView {
//    private let chechbox: UIButton = {
//        let button = UIButton()
//        button.setImage(UIImage(systemName: "square"), for: UIButton.State.normal)
//        button.tintColor = Colors.gray_400
//
//        button.translatesAutoresizingMaskIntoConstraints = false
//        return button
//    }()
    
    private let iconPointSize: CGFloat = Metrics.s6 // Assumindo Metrics.s6 é 24.0

    private let chechbox: UIButton = {
        let button = UIButton()
        let symbolConfig = UIImage.SymbolConfiguration(pointSize: Metrics.s6, weight: .light, scale: .large)
        let uncheckedImage = UIImage(systemName: "square", withConfiguration: symbolConfig)
        let checkedImage = UIImage(systemName: "checkmark.square.fill", withConfiguration: symbolConfig)
        button.setImage(uncheckedImage, for: .normal)
        button.tintColor = Colors.gray_400
        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }()
    
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.textColor = Colors.gray_700
        label.font = Typographies.input
        
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    init(title: String) {
        super.init(frame: .zero)
        self.translatesAutoresizingMaskIntoConstraints = false
        
        self.titleLabel.text = title
        self.setupView()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupView() {
        self.addSubview(self.chechbox)
        self.addSubview(self.titleLabel)
        
        self.setupConstraints()
    }
    
    private func setupConstraints() {
        NSLayoutConstraint.activate([
            self.chechbox.topAnchor.constraint(equalTo: self.topAnchor),
            self.chechbox.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.chechbox.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            self.chechbox.widthAnchor.constraint(equalToConstant: Metrics.s6),
            self.chechbox.heightAnchor.constraint(equalToConstant: Metrics.s6),
            
            self.titleLabel.centerYAnchor.constraint(equalTo: self.chechbox.centerYAnchor),
            self.titleLabel.leadingAnchor.constraint(equalTo: self.chechbox.trailingAnchor, constant: Metrics.s3),
        ])
    }
}
