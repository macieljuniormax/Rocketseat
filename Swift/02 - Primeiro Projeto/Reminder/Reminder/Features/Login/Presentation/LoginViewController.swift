//
//  LoginBottonSheetViewController.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 15/06/25.
//

import Foundation
import UIKit

class LoginViewController: UIViewController {
    private let loginView: LoginView
    private let loginViewModel: LoginViewModel = LoginViewModel()
    private var handleAreaHeigh: CGFloat = 50.0
    private weak var flowDelegate: LoginFlowDelegate?
    
    init(contentView: LoginView,
         flowDelegate: LoginFlowDelegate) {
        self.loginView = contentView
        self.flowDelegate = flowDelegate
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() -> Void {
        super.viewDidLoad()
        
        self.setupUI()
        self.setupBindViewModel()
    }
    
    private func setupUI() -> Void {
        self.view.addSubview(self.loginView)
        
        self.loginView.viewDelegate = self
        self.buildHierarchy()
    }
    
    private func buildHierarchy() -> Void {
        self.loginView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            self.loginView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            self.loginView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            self.loginView.bottomAnchor.constraint(equalTo: self.view.bottomAnchor),
        ])
        
        let heightConstraint = self.loginView.heightAnchor.constraint(equalTo: self.view.heightAnchor, multiplier: 0.5)
        heightConstraint.isActive = true
    }

    
    private func handlePanGesture() -> Void {
        
    }
    
    private func setupBindViewModel() -> Void {
        self.loginViewModel.onLoginSucess = { [weak self] username in
            self?.presentSaveLoginAlert(email: username)
        }
        
        self.loginViewModel.onLoginError = { [weak self] errorMessage in
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
        self.loginViewModel.doAuthentication(username: user, password: password)
    }
}

/* MARK: - Animations */
extension LoginViewController {
    func animateShow(completion: (() -> Void)? = nil) -> Void {
        self.view.layoutIfNeeded()
        self.loginView.transform = CGAffineTransform(translationX: 0, y: self.loginView.frame.height)
        UIView.animate(withDuration: 0.5, animations: {
            self.loginView.transform = CGAffineTransform.identity
            self.view.layoutIfNeeded()
        }) {
            _ in completion?()
        }
    }
}
