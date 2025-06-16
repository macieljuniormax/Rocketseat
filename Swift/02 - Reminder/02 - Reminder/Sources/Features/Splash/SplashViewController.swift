//
//  SplashViewController.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 15/06/25.
//

import Foundation
import UIKit

class SplashViewController: UIViewController {
    let contentView = SplashView()
    
    override func viewDidLoad() -> Void {
        super.viewDidLoad()
        
        setup()
    }
    
    private func setup() -> Void {
        self.view.addSubview(self.contentView)
        self.navigationController?.navigationBar.isHidden = true
        self.view.backgroundColor = Colors.red_primary
        
        self.setupConstraints()
        self.setupGestures()
    }
    
    private func setupConstraints() -> Void {
        self.contentView.translatesAutoresizingMaskIntoConstraints = false
        
        NSLayoutConstraint.activate([
            self.contentView.topAnchor.constraint(equalTo: view.topAnchor),
            self.contentView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            self.contentView.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            self.contentView.bottomAnchor.constraint(equalTo: view.bottomAnchor),
        ])
    }
    
    private func setupGestures() -> Void {
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(self.showLoginBottomSheet))
        self.view.addGestureRecognizer(tapGesture)
    }
    
    @objc private func showLoginBottomSheet() -> Void {
        let loginBottomSheet = LoginBottomSheetViewController()
        loginBottomSheet.modalPresentationStyle = UIModalPresentationStyle.overFullScreen
        loginBottomSheet.modalTransitionStyle = UIModalTransitionStyle.crossDissolve
        self.present(loginBottomSheet, animated: false) {
            loginBottomSheet.animateShow()
        }
    }
}
