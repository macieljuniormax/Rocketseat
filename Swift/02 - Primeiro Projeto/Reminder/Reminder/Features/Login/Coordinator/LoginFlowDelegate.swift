//
//  LoginFlowDelegate.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation

public protocol LoginFlowDelegate: AnyObject {
    func navigateToHome() -> Void 
}
