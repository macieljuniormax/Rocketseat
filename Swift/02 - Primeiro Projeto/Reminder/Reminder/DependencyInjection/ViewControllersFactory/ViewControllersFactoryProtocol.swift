//
//  ViewControllersFactoryProtocol.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation

protocol ViewControllersFactoryProtocol {
    func makeSplashViewController(delegate: SplashFlowDelegate) -> SplashViewController
    func makeLoginViewController(delegate: LoginFlowDelegate) -> LoginViewController
}
