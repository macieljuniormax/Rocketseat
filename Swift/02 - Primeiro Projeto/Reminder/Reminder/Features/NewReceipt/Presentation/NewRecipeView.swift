//
//  NewReceiptView.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 18/06/25.
//

import Foundation
import UIKit

class NewRecipeView: UIView {
    internal let backButton: UIButton = {
        let button = UIButton(type: UIButton.ButtonType.system)
        button.setImage(UIImage(systemName: "arrow.left",
                                withConfiguration: UIImage.SymbolConfiguration(weight: .bold)),
                        for: UIControl.State.normal)
        button.tintColor = Colors.gray_800
        
        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }()
    
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.text = "newReceipt.label.title".localized
        label.font = Typographies.heading
        label.textColor = Colors.red_primary
        
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private let descriptionLabel: UILabel = {
        let label = UILabel()
        label.text = "newReceipt.label.description".localized
        label.font = Typographies.body
        label.textColor = Colors.gray_700
        label.numberOfLines = 0
        
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private let remedyInput: Input = Input(title: "Remédio", placeholder: "Nome do medicamento")
    private let timeInput: Input = Input(title: "Horário", placeholder: "12:00")
    private let recurrrenceInput: Input = Input(title: "Recorrência", placeholder: "Selecione")
    private let takeNowCheckbox: Checkbox = Checkbox(title: "Tomar agora")
    
    private let addButton: UIButton = {
        let button = UIButton(type: UIButton.ButtonType.system)
        button.setTitle("newReceipt.button.title".localized, for: UIControl.State.normal)
        button.setTitleColor(Colors.gray_100, for: UIControl.State.normal)
        button.titleLabel?.font = Typographies.subheading
        button.backgroundColor = Colors.red_primary
        button.layer.cornerRadius = Metrics.s7
        
        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        self.setupView()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupView() -> Void {
        self.addSubview(self.backButton)
        self.addSubview(self.titleLabel)
        self.addSubview(self.descriptionLabel)
        self.addSubview(self.addButton)
        self.addSubview(self.remedyInput)
        self.addSubview(self.timeInput)
        self.addSubview(self.recurrrenceInput)
        self.addSubview(self.takeNowCheckbox)
        
        self.setupConstraints()
    }
    
    private func setupConstraints() -> Void {
        NSLayoutConstraint.activate([
            self.backButton.topAnchor.constraint(equalTo: self.topAnchor, constant: Metrics.s8),
            self.backButton.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.s8),
            self.backButton.heightAnchor.constraint(equalToConstant: Metrics.s6),
            self.backButton.widthAnchor.constraint(equalToConstant: Metrics.s6),
            
            self.titleLabel.topAnchor.constraint(equalTo: self.backButton.bottomAnchor, constant: Metrics.s6),
            self.titleLabel.leadingAnchor.constraint(equalTo: self.backButton.leadingAnchor),
            
            self.descriptionLabel.topAnchor.constraint(equalTo: self.titleLabel.bottomAnchor, constant: Metrics.s2),
            self.descriptionLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -Metrics.s8),
            self.descriptionLabel.leadingAnchor.constraint(equalTo: self.titleLabel.leadingAnchor),
            
            self.remedyInput.topAnchor.constraint(equalTo: self.descriptionLabel.bottomAnchor, constant: Metrics.s10),
            self.remedyInput.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -Metrics.s8),
            self.remedyInput.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.s8),
            
            self.timeInput.topAnchor.constraint(equalTo: self.remedyInput.bottomAnchor, constant: Metrics.s5),
            self.timeInput.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -Metrics.s8),
            self.timeInput.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.s8),
            
            self.recurrrenceInput.topAnchor.constraint(equalTo: self.timeInput.bottomAnchor, constant: Metrics.s5),
            self.recurrrenceInput.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -Metrics.s8),
            self.recurrrenceInput.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.s8),
            
            self.takeNowCheckbox.topAnchor.constraint(equalTo: self.recurrrenceInput.bottomAnchor, constant: Metrics.s5),
            self.takeNowCheckbox.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.s8),
            
            self.addButton.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -Metrics.s8),
            self.addButton.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            self.addButton.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.s8),
            self.addButton.heightAnchor.constraint(equalToConstant: Metrics.buttomSize),
        ])
    }
}
