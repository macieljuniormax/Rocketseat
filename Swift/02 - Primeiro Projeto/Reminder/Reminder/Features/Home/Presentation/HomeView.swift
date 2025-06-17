//
//  HomeView.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 17/06/25.
//

import Foundation
import UIKit

class HomeView: UIView {
    public weak var viewDelegate : HomeViewDelegate?
    
    let profileBackground: UIView = {
        let view = UIView()
        view.backgroundColor = Colors.gray_300
        
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    let contentBackground: UIView = {
        let view = UIView()
        view.backgroundColor = Colors.gray_100
        view.layer.cornerRadius = Metrics.s6
        view.layer.masksToBounds = true
        
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    let profileImage: UIImageView = {
        let imageView = UIImageView()
        imageView.image = UIImage(named: "profile-image")
        imageView.contentMode = UIView.ContentMode.scaleAspectFill
        imageView.clipsToBounds = true
        imageView.isUserInteractionEnabled = true
        imageView.layer.cornerRadius = Metrics.s8
        
        imageView.translatesAutoresizingMaskIntoConstraints = false
        return imageView
    }()
    
    let welcomeLabel: UILabel = {
        let label = UILabel()
        label.text = "home.label.welcome".localized
        label.textColor = Colors.gray_700
        label.font = Typographies.input
        
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    let nameLabel: UILabel = {
        let label = UILabel()
        label.text = "Júlio Santana"
        label.textColor = Colors.gray_800
        label.font = Typographies.heading
        
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    let feedBackButton: UIButton = {
        let button = UIButton()
        button.setTitle("home.buttom.text".localized, for: UIControl.State.normal)
        button.setTitleColor(Colors.gray_100, for: .normal)
        button.titleLabel?.font = Typographies.subheading
        button.backgroundColor = Colors.gray_800
        button.layer.cornerRadius = Metrics.s7
        
        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.setupView()
        self.backgroundColor = Colors.gray_300
        
       
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupView() {
        self.addSubview(self.profileBackground)
        self.profileBackground.addSubview(self.profileImage)
        self.profileBackground.addSubview(self.welcomeLabel)
        self.profileBackground.addSubview(self.nameLabel)

        self.addSubview(self.contentBackground)
        self.contentBackground.addSubview(self.feedBackButton)

        self.setupConstraints()
        self.setupImageGesture()
    }
    
    private func setupConstraints() {
        NSLayoutConstraint.activate([
            self.profileBackground.topAnchor.constraint(equalTo: self.topAnchor, constant: Metrics.s12),
            self.profileBackground.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.profileBackground.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.profileBackground.heightAnchor.constraint(equalToConstant: Metrics.profileSize),
            
            self.profileImage.topAnchor.constraint(equalTo: self.profileBackground.topAnchor, constant: Metrics.s8),
            self.profileImage.leadingAnchor.constraint(equalTo: self.profileBackground.leadingAnchor, constant: Metrics.s8),
            self.profileImage.heightAnchor.constraint(equalToConstant: Metrics.profileImageSize),
            self.profileImage.widthAnchor.constraint(equalToConstant: Metrics.profileImageSize),
            
            self.welcomeLabel.topAnchor.constraint(equalTo: self.profileImage.bottomAnchor, constant: Metrics.s4),
            self.welcomeLabel.leadingAnchor.constraint(equalTo: self.profileImage.leadingAnchor),
            
            self.nameLabel.topAnchor.constraint(equalTo: self.welcomeLabel.bottomAnchor, constant: Metrics.s1),
            self.nameLabel.leadingAnchor.constraint(equalTo: self.profileImage.leadingAnchor),

            self.contentBackground.topAnchor.constraint(equalTo: self.profileBackground.bottomAnchor),
            self.contentBackground.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.contentBackground.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.contentBackground.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            
            self.feedBackButton.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: Metrics.s6),
            self.feedBackButton.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -Metrics.s6),
            self.feedBackButton.bottomAnchor.constraint(equalTo: self.bottomAnchor, constant: -Metrics.s12),
            self.feedBackButton.heightAnchor.constraint(equalToConstant: Metrics.buttomSize)
        ])
    }
    
    private func setupImageGesture() {
        let tapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(profileImageTapped))
        self.profileImage.addGestureRecognizer(tapGestureRecognizer)
    }
    
    @objc private func profileImageTapped() {
        self.viewDelegate?.didTapProfileImage()
    }
}
