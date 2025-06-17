//
//  ViewControllersFactory.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation

final class ViewControllersFactory: ViewControllersFactoryProtocol {
    func makeSplashViewController(delegate: SplashFlowDelegate) -> SplashViewController {
        let contentView = SplashView()
        let viewController = SplashViewController(contentView: contentView, delegate: delegate)
        
        return viewController
    }
    
    func makeLoginViewController(delegate: LoginFlowDelegate) -> LoginViewController {
        let contentView = LoginView()
        let viewController = LoginViewController(contentView: contentView, delegate: delegate)
        
        return viewController
    }
}
