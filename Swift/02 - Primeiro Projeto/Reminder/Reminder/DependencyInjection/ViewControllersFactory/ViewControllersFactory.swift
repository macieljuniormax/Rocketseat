//
//  ViewControllersFactory.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation

final class ViewControllersFactory: ViewControllersFactoryProtocol {
    func makeSplashViewController(flowDelegate: SplashFlowDelegate) -> SplashViewController {
        let contentView: SplashView = SplashView()
        let viewController: SplashViewController = SplashViewController(contentView: contentView, flowDelegate: flowDelegate)
        
        return viewController
    }
    
    func makeLoginViewController(flowDelegate: LoginFlowDelegate) -> LoginViewController {
        let contentView: LoginView = LoginView()
        let viewController: LoginViewController = LoginViewController(contentView: contentView, flowDelegate: flowDelegate)
        
        return viewController
    }
    
    func makeHomeViewController(flowDelegate: HomeFlowDelegate) -> HomeViewController {
        let contentView: HomeView = HomeView()
        let viewController: HomeViewController = HomeViewController(contentView: contentView, flowDelegate: flowDelegate)
        
        return viewController
    }
}
