//
//  ReminderFlowController.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation
import UIKit

class ReminderFlowController {
    /* MARK: - Properties */
    private var navigationController: UINavigationController
    private let viewControllerFactory: ViewControllersFactoryProtocol
    
    /* MARK: - Init */
    public init() {
        self.navigationController = UINavigationController()
        self.viewControllerFactory = ViewControllersFactory()
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    /* MARK: - StartFlow */
    func start() -> UINavigationController {
        let startViewController: NewReceiptViewController /*SplashViewController = self.viewControllerFactory.makeSplashViewController(flowDelegate: self)*/ = NewReceiptViewController()
        self.navigationController = UINavigationController(rootViewController: startViewController)
        
        return self.navigationController
    }
}

/* MARK: - Splash */
extension ReminderFlowController: SplashFlowDelegate {
    func openLogin() {
        let loginViewController: LoginViewController = self.viewControllerFactory.makeLoginViewController(flowDelegate: self)
        loginViewController.modalPresentationStyle = UIModalPresentationStyle.overFullScreen
        loginViewController.modalTransitionStyle = UIModalTransitionStyle.crossDissolve
        self.navigationController.present(loginViewController, animated: false) {
            loginViewController.animateShow()
        }
        
        func navigateToHome() {
            self.navigationController.dismiss(animated: false)
            let homeViewController: HomeViewController =  self.viewControllerFactory.makeHomeViewController(flowDelegate: self)
            self.navigationController.pushViewController(homeViewController, animated: true)
        }
    }
}

/* MARK: - Login */
extension ReminderFlowController: LoginFlowDelegate {
    func navigateToHome() {
        self.navigationController.dismiss(animated: false)
        let homeViewController: HomeViewController =  self.viewControllerFactory.makeHomeViewController(flowDelegate: self)
        self.navigationController.pushViewController(homeViewController, animated: true)
    }
}

//MARK: - Home
extension ReminderFlowController: HomeFlowDelegate {
    func navigateToRecipes() {}
    func logout() {
        self.navigationController.viewControllers = []
        let splashViewController: SplashViewController = self.viewControllerFactory.makeSplashViewController(flowDelegate: self)
        self.navigationController.pushViewController(splashViewController, animated: true)
    }
}
