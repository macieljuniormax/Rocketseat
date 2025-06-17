//
//  HomeFlowDelegate.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 17/06/25.
//

import Foundation

public protocol HomeFlowDelegate: AnyObject {
    func navigateToRecipes()
    func logout()
}
