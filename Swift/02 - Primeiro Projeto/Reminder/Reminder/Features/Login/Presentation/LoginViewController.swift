//
//  LoginBottonSheetViewController.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 15/06/25.
//

import Foundation
import UIKit

class LoginViewController: UIViewController {
    private let contentView: LoginView
    private let viewModel: LoginViewModel = LoginViewModel()
    private var handleAreaHeigh: CGFloat = 50.0
    private weak var delegate: LoginFlowDelegate?
    
    init(contentView: LoginView,
         delegate: LoginFlowDelegate) {
        self.contentView = contentView
        self.delegate = delegate
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() -> Void {
        super.viewDidLoad()
        
        self.contentView.delegate = self
        self.setupUI()
        self.setupGesture()
        self.bindViewModel()
    }
    
    private func setupUI() -> Void {
        self.view.addSubview(self.contentView)
        self.contentView.translatesAutoresizingMaskIntoConstraints = false
        
        self.setupConstraints()
    }
    
    private func setupConstraints() -> Void {
        NSLayoutConstraint.activate([
            self.contentView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            self.contentView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            self.contentView.bottomAnchor.constraint(equalTo: self.view.bottomAnchor),
        ])
        
        let heightConstraint = self.contentView.heightAnchor.constraint(equalTo: self.view.heightAnchor, multiplier: 0.5)
        heightConstraint.isActive = true
    }
    
    private func setupGesture() -> Void {
        
    }
    
    private func handlePanGesture() -> Void {
        
    }
    
    private func bindViewModel() -> Void {
        self.viewModel.succesResult = { [weak self] username in
            self?.presentSaveLoginAlert(email: username)
        }
    }
    
    private func presentSaveLoginAlert(email: String) -> Void {
        let alertController: UIAlertController = UIAlertController(title: "Salvar Acesso",
                                                                   message: "Deseja se manter conectado?",
                                                                   preferredStyle: UIAlertController.Style.alert)
        let saveAction: UIAlertAction = UIAlertAction(title: "Sim",
                                                      style: UIAlertAction.Style.default) { _ in
            let user: User = User(email: email, isUserSave: true)
            UserDefaultsManager.saveUser(user: user)
            self.delegate?.navigateToHome()
        }
        
        let cancelAction: UIAlertAction = UIAlertAction(title: "Não",
                                                      style: UIAlertAction.Style.cancel) { _ in
            self.delegate?.navigateToHome()
        }
        
        alertController.addAction(saveAction)
        alertController.addAction(cancelAction)
        
        self.present(alertController, animated: true)
    }
    
    func animateShow(completion: (() -> Void)? = nil) -> Void {
        self.view.layoutIfNeeded()
        self.contentView.transform = CGAffineTransform(translationX: 0, y: self.contentView.frame.height)
        UIView.animate(withDuration: 0.3, animations: {
            self.contentView.transform = CGAffineTransform.identity
            self.view.layoutIfNeeded()
        }) {
            _ in completion?()
        }
    }
}

extension LoginViewController: LoginViewDelegate {
    func sendLoginData(user: String, password: String) {
        self.viewModel.doAuthentication(username: user, password: password)
    }
}
