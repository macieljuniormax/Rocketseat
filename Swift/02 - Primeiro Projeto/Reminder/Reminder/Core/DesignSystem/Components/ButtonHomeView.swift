//
//  ButtonHomeView.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 17/06/25.
//

import Foundation
import UIKit

class ButtonHomeView: UIView {
    private let iconView: UIView = {
        let view = UIView()
        view.backgroundColor = Colors.gray_300
        view.layer.cornerRadius = Metrics.s2
        
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private let iconImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.contentMode = UIView.ContentMode.scaleAspectFit
        
        imageView.translatesAutoresizingMaskIntoConstraints = false
        return imageView
    }()
    
    private let separatorView: UIView = {
        let view = UIView()
        
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.font = Typographies.subheading
        label.textColor = Colors.gray_800
        label.numberOfLines = 0
        
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private let descriptionLabel: UILabel = {
        let label = UILabel()
        label.font = Typographies.body
        label.textColor = Colors.gray_700
        label.numberOfLines = 0
        
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private let arrowImageView: UIImageView = {
        let imageView = UIImageView(image: UIImage(systemName: "chevron.right"))
        imageView.contentMode = UIView.ContentMode.scaleAspectFit
        imageView.tintColor = Colors.gray_700
        
        imageView.translatesAutoresizingMaskIntoConstraints = false
        return imageView
    }()
    
    init(icon: UIImage, title: String, description: String){
        super.init(frame: .zero)
        
        self.iconImageView.image = icon
        self.titleLabel.text = title
        self.descriptionLabel.text = description
        
        self.setupView()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupView() -> Void {
        self.addSubview(self.iconView)
        iconView.addSubview(iconImageView)
        self.addSubview(self.separatorView)
        separatorView.addSubview(self.titleLabel)
        separatorView.addSubview(self.descriptionLabel)
        self.addSubview(self.arrowImageView)
        
        self.setupConstraints()
    }
    
    private func setupSelfClass() -> Void {
        self.backgroundColor = Colors.gray_200
        self.layer.cornerRadius = Metrics.s3
        self.translatesAutoresizingMaskIntoConstraints = false
    }
    
    private func setupConstraints() -> Void {
        NSLayoutConstraint.activate([
            self.iconView.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.s3),
            self.iconView.centerYAnchor.constraint(equalTo: self.centerYAnchor),
            self.iconView.heightAnchor.constraint(equalToConstant: 80),
            self.iconView.widthAnchor.constraint(equalToConstant: 80),
            
        
            self.iconImageView.centerXAnchor.constraint(equalTo: self.centerXAnchor),
            self.iconImageView.centerYAnchor.constraint(equalTo: self.centerYAnchor),
            self.iconImageView.heightAnchor.constraint(equalToConstant: Metrics.s12),
            self.iconImageView.widthAnchor.constraint(equalToConstant: Metrics.s12),
            
            self.separatorView.centerYAnchor.constraint(equalTo: iconView.centerYAnchor, constant: Metrics.s3),
            self.separatorView.trailingAnchor.constraint(equalTo: iconImageView.trailingAnchor, constant: Metrics.s4),
            self.separatorView.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: -Metrics.s5),
            
            self.titleLabel.topAnchor.constraint(equalTo: self.separatorView.topAnchor),
            self.titleLabel.leadingAnchor.constraint(equalTo: self.separatorView.leadingAnchor),
            self.titleLabel.trailingAnchor.constraint(equalTo: self.separatorView.trailingAnchor),
            
            self.descriptionLabel.topAnchor.constraint(equalTo: titleLabel.bottomAnchor, constant: Metrics.s2),
            self.descriptionLabel.leadingAnchor.constraint(equalTo: separatorView.leadingAnchor),
            self.descriptionLabel.trailingAnchor.constraint(equalTo: separatorView.trailingAnchor),
            self.descriptionLabel.bottomAnchor.constraint(lessThanOrEqualTo: separatorView.bottomAnchor),
            
            self.arrowImageView.topAnchor.constraint(equalTo: iconView.topAnchor),
            self.arrowImageView.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -Metrics.s4),
            self.arrowImageView.heightAnchor.constraint(equalToConstant: Metrics.s4),
            self.arrowImageView.widthAnchor.constraint(equalToConstant: Metrics.s4),
        ])
    }
    
}
