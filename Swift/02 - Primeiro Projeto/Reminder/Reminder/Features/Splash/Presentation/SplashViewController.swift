//
//  SplashViewController.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 15/06/25.
//

import Foundation
import UIKit

class SplashViewController: UIViewController {
    private let contentView: SplashView
    private weak var flowDelegate: SplashFlowDelegate?
    
    init(contentView: SplashView,
         flowDelegate: SplashFlowDelegate) {
        self.contentView = contentView
        self.flowDelegate = flowDelegate
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() -> Void {
        super.viewDidLoad()

        self.startBreathingAnimation()
        self.setupUI()
    }
    
    private func setupUI() -> Void {
        self.view.addSubview(self.contentView)
        self.navigationController?.navigationBar.isHidden = true
        self.view.backgroundColor = Colors.red_primary
        
        self.buildHierarchy()
    }
    
    private func buildHierarchy() -> Void {
        setupContentViewToBounds(contentView: self.contentView)
    }
    
    private func decideNavigationFlow() -> Void {
        if let user: User = UserDefaultsManager.loadUser(), user.isUserSave {
            self.flowDelegate?.navigateToHome()
        } else {
            self.showLogin()
        }
    }
    
    @objc private func showLogin() -> Void {
        self.animateLogoUp()
        self.flowDelegate?.openLogin()
    }
}

/* MARK: - Animations */
extension SplashViewController {
    private func startBreathingAnimation() {
        UIView.animate(withDuration: 1.5, delay: 0.0, animations: {
            self.contentView.logoImageView.transform = CGAffineTransform(scaleX: 1.1, y: 1.1)
        }, completion: { _ in self.decideNavigationFlow() })
    }
    
    private func animateLogoUp() {
        UIView.animate(withDuration: 0.6, delay: 0.0,  options: [UIView.AnimationOptions.curveEaseOut],
                       animations: {
            self.contentView.logoImageView.transform = self.contentView.logoImageView.transform.translatedBy(x: 0, y: -100)
        })
    }
}
