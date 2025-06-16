//
//  LoginBottonSheetViewController.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 15/06/25.
//

import Foundation
import UIKit

class LoginBottomSheetViewController: UIViewController {
    let loginView = LoginBottomSheetView()
    let viewModel = LoginBottomSheetViewModel()
    var handleAreaHeigh: CGFloat = 50.0
    
    override func viewDidLoad() -> Void {
        super.viewDidLoad()
        
        self.loginView.delegate = self
        self.setupUI()
        self.setupGesture()
    }
    
    private func setupUI() -> Void {
        self.view.addSubview(self.loginView)
        self.loginView.translatesAutoresizingMaskIntoConstraints = false
        
        self.setupConstraints()
    }
    
    private func setupConstraints() -> Void {
        NSLayoutConstraint.activate([
            self.loginView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            self.loginView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            self.loginView.bottomAnchor.constraint(equalTo: self.view.bottomAnchor),
        ])
        
        let heightConstraint = loginView.heightAnchor.constraint(equalTo: self.view.heightAnchor, multiplier: 0.5)
        heightConstraint.isActive = true
    }
    
    private func setupGesture() -> Void {
        
    }
    
    private func handlePanGesture() -> Void {
        
    }
    
    func animateShow(completion: (() -> Void)? = nil) -> Void {
        self.view.layoutIfNeeded()
        self.loginView.transform = CGAffineTransform(translationX: 0, y: self.loginView.frame.height)
        UIView.animate(withDuration: 0.3, animations: {
            self.loginView.transform = CGAffineTransform.identity
            self.view.layoutIfNeeded()
        }) {
            _ in completion?()
        }
    }
}

extension LoginBottomSheetViewController: LoginBottomSheetViewDelegate {
    func sendLoginData(user: String, password: String) {
        self.viewModel.doAuthentication(username: user, password: password)
    }
}
