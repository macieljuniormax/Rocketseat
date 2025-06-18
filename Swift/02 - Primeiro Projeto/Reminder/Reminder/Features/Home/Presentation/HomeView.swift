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
    
    private let profileBackground: UIView = {
        let view = UIView()
        view.backgroundColor = Colors.gray_300
        
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private let profile: UIView = {
        let view = UIView()
        
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private let contentBackground: UIView = {
        let view = UIView()
        view.backgroundColor = Colors.gray_100
        view.layer.cornerRadius = Metrics.s6
        view.layer.maskedCorners = [CACornerMask.layerMinXMinYCorner, CACornerMask.layerMaxXMinYCorner]
        view.layer.masksToBounds = true
        
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private let content: UIView = {
        let view = UIView()
        
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    internal let profileImage: UIImageView = {
        let imageView = UIImageView()
        imageView.contentMode = UIView.ContentMode.scaleAspectFill
        imageView.clipsToBounds = true
        imageView.isUserInteractionEnabled = true
        imageView.layer.cornerRadius = Metrics.s8
        
        imageView.translatesAutoresizingMaskIntoConstraints = false
        return imageView
    }()
    
    private let welcomeLabel: UILabel = {
        let label = UILabel()
        label.text = "home.label.welcome".localized
        label.textColor = Colors.gray_700
        label.font = Typographies.input
        
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    internal let nameTextFiled: UITextField = {
        let textField = UITextField()
        textField.placeholder = "Insira seu nome"
        textField.textColor = Colors.gray_800
        textField.font = Typographies.heading
        textField.returnKeyType = UIReturnKeyType.done
        
        textField.translatesAutoresizingMaskIntoConstraints = false
        return textField
    }()
    
    private let logoutButton: UIButton = {
        let button = UIButton(type: UIButton.ButtonType.system)
        button.setImage(UIImage(systemName: "rectangle.portrait.and.arrow.forward",
                                withConfiguration: UIImage.SymbolConfiguration(weight: .bold)),
                        for: UIControl.State.normal)
        button.tintColor = Colors.red_primary
        
        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }()
    
    private let myPrescriptionsButton: ButtonHomeView = {
        let button = ButtonHomeView(icon:UIImage(named: "paper")!,
                                    title: "Minhas receitas",
                                    description: "Acompanhe os medicamentos e gerencie lembretes")
        button.setContentHuggingPriority(.defaultHigh, for: .vertical)
        button.setContentCompressionResistancePriority(.defaultHigh, for: .vertical)
        
        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }()
    
    private let newPrescriptionsButton: ButtonHomeView = {
        let button = ButtonHomeView(icon:UIImage(named: "pills")!,
                                    title: "Nova receita",
                                    description: "Cadastre novos lembretes de receitas")
        button.setContentHuggingPriority(.defaultHigh, for: .vertical)
        button.setContentCompressionResistancePriority(.defaultHigh, for: .vertical)
        
        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }()
    
    private let feedBackButton: UIButton = {
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
        self.setupTextField()
        
        self.logoutButton.addTarget(self, action: #selector(logoutButtonTapped), for: UIControl.Event.touchUpInside)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupView() {
        self.backgroundColor = Colors.gray_300
        
        self.addSubview(self.profileBackground)
        self.profileBackground.addSubview(self.profile)
        
        self.profile.addSubview(self.profileImage)
        self.profile.addSubview(self.welcomeLabel)
        self.profile.addSubview(self.nameTextFiled)
        self.profile.addSubview(self.logoutButton)

        self.addSubview(self.contentBackground)
        self.contentBackground.addSubview(self.content)
        
        self.content.addSubview(self.myPrescriptionsButton)
        self.content.addSubview(self.newPrescriptionsButton)
        self.content.addSubview(self.feedBackButton)

        self.setupConstraints()
        self.setupImageGesture()
    }
    
    private func setupConstraints() {
        NSLayoutConstraint.activate([
            self.profileBackground.topAnchor.constraint(equalTo: self.topAnchor),
            self.profileBackground.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.profileBackground.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            
            self.profile.topAnchor.constraint(equalTo: self.safeAreaLayoutGuide.topAnchor),
            self.profile.bottomAnchor.constraint(equalTo: self.profileBackground.bottomAnchor),
            self.profile.leadingAnchor.constraint(equalTo: self.profileBackground.leadingAnchor),
            self.profile.trailingAnchor.constraint(equalTo: self.profileBackground.trailingAnchor),
            
            self.profileImage.heightAnchor.constraint(equalToConstant: Metrics.profileImageSize),
            self.profileImage.widthAnchor.constraint(equalToConstant: Metrics.profileImageSize),
            self.profileImage.topAnchor.constraint(equalTo: self.profile.topAnchor, constant: Metrics.s8),
            self.profileImage.leadingAnchor.constraint(equalTo: self.profile.leadingAnchor, constant: Metrics.s8),

            self.welcomeLabel.topAnchor.constraint(equalTo: self.profileImage.bottomAnchor, constant: Metrics.s4),
            self.welcomeLabel.leadingAnchor.constraint(equalTo: self.profileImage.leadingAnchor),

            self.nameTextFiled.topAnchor.constraint(equalTo: self.welcomeLabel.bottomAnchor, constant: Metrics.s1),
            self.nameTextFiled.leadingAnchor.constraint(equalTo: self.profileImage.leadingAnchor),
            self.nameTextFiled.bottomAnchor.constraint(equalTo: self.profile.bottomAnchor, constant: -Metrics.s8),
            
            self.logoutButton.heightAnchor.constraint(equalToConstant: Metrics.s6),
            self.logoutButton.widthAnchor.constraint(equalToConstant: Metrics.s6),
            self.logoutButton.topAnchor.constraint(equalTo: self.profileImage.topAnchor),
            self.logoutButton.trailingAnchor.constraint(equalTo: self.profile.trailingAnchor, constant: -Metrics.s8),

            self.contentBackground.topAnchor.constraint(equalTo: self.profileBackground.bottomAnchor),
            self.contentBackground.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            self.contentBackground.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            self.contentBackground.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            
            self.content.topAnchor.constraint(equalTo: self.contentBackground.topAnchor),
            self.content.leadingAnchor.constraint(equalTo: self.contentBackground.leadingAnchor),
            self.content.trailingAnchor.constraint(equalTo: self.contentBackground.trailingAnchor),
            self.content.bottomAnchor.constraint(equalTo: self.safeAreaLayoutGuide.bottomAnchor),

            self.myPrescriptionsButton.topAnchor.constraint(equalTo: self.content.topAnchor, constant: Metrics.s10),
            self.myPrescriptionsButton.leadingAnchor.constraint(equalTo: self.content.leadingAnchor, constant: Metrics.s8),
            self.myPrescriptionsButton.trailingAnchor.constraint(equalTo: self.content.trailingAnchor, constant: -Metrics.s8),
            
            self.newPrescriptionsButton.topAnchor.constraint(equalTo: self.myPrescriptionsButton.bottomAnchor, constant: Metrics.s4),
            self.newPrescriptionsButton.leadingAnchor.constraint(equalTo: self.content.leadingAnchor, constant: Metrics.s8),
            self.newPrescriptionsButton.trailingAnchor.constraint(equalTo: self.content.trailingAnchor, constant: -Metrics.s8),
            
            self.feedBackButton.leadingAnchor.constraint(equalTo: self.content.leadingAnchor, constant: Metrics.s6),
            self.feedBackButton.trailingAnchor.constraint(equalTo: self.content.trailingAnchor, constant: -Metrics.s6),
            self.feedBackButton.bottomAnchor.constraint(equalTo: self.content.bottomAnchor),
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
    
    private func setupTextField() {
        self.nameTextFiled.addTarget(self, action: #selector(nameTextFieldDidEndEditing), for: UIControl.Event.editingChanged)
        self.nameTextFiled.delegate = self
    }
    
    @objc private func nameTextFieldDidEndEditing () {
        let username = self.nameTextFiled.text ?? ""
        UserDefaultsManager.saveUserName(name: username)
    }
    
    @objc private func logoutButtonTapped() {
        self.viewDelegate?.didTapLogoutButton()
    }
}

extension HomeView: UITextFieldDelegate {
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        let userName = textField.text ?? ""
        UserDefaultsManager.saveUserName(name: userName)
        return true
    }
}
