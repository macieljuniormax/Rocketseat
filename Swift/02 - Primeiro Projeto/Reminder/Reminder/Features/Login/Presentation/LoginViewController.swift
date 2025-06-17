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
    private weak var flowDelegate: LoginFlowDelegate?
    
    init(contentView: LoginView,
         flowDelegate: LoginFlowDelegate) {
        self.contentView = contentView
        self.flowDelegate = flowDelegate
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() -> Void {
        super.viewDidLoad()
        
        self.contentView.viewDelegate = self
        self.setupUI()
        self.setupBindViewModel()
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

    
    private func handlePanGesture() -> Void {
        
    }
    
    private func setupBindViewModel() -> Void {
        self.viewModel.onLoginSucess = { [weak self] username in
            self?.presentSaveLoginAlert(email: username)
        }
        
        self.viewModel.onLoginError = { [weak self] errorMessage in
            self?.presentSaveLoginAlert(message: errorMessage)
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
            self.flowDelegate?.navigateToHome()
        }
        
        let cancelAction: UIAlertAction = UIAlertAction(title: "Não",
                                                      style: UIAlertAction.Style.cancel) { _ in
            self.flowDelegate?.navigateToHome()
        }
        
        alertController.addAction(saveAction)
        alertController.addAction(cancelAction)
        
        self.present(alertController, animated: true)
    }
    
    private func presentSaveLoginAlert(message: String) -> Void {
        let alertController: UIAlertController = UIAlertController(title: "Credenciais Inválidas",
                                                                   message: message,
                                                                   preferredStyle: UIAlertController.Style.alert)
        let retryAction: UIAlertAction = UIAlertAction(title: "Tentar Novamente",
                                                        style: UIAlertAction.Style.default)
        alertController.addAction(retryAction)
        
        self.present(alertController, animated: true)
    }
}

/* MARK: - Delegates */
extension LoginViewController: LoginViewDelegate {
    func sendLoginData(user: String, password: String) {
        self.viewModel.doAuthentication(username: user, password: password)
    }
}

/* MARK: - Animations */
extension LoginViewController {
    func animateShow(completion: (() -> Void)? = nil) -> Void {
        self.view.layoutIfNeeded()
        self.contentView.transform = CGAffineTransform(translationX: 0, y: self.contentView.frame.height)
        UIView.animate(withDuration: 0.5, animations: {
            self.contentView.transform = CGAffineTransform.identity
            self.view.layoutIfNeeded()
        }) {
            _ in completion?()
        }
    }
}
