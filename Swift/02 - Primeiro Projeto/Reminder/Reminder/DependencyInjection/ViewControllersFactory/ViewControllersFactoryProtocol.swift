//
//  ViewControllersFactoryProtocol.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation

protocol ViewControllersFactoryProtocol {
    func makeSplashViewController(flowDelegate: SplashFlowDelegate) -> SplashViewController
    func makeLoginViewController(flowDelegate: LoginFlowDelegate) -> LoginViewController
    func makeHomeViewController(flowDelegate: HomeFlowDelegate) -> HomeViewController
}
