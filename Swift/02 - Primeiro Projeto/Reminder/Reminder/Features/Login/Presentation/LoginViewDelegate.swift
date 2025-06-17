//
//  LoginBottomSheetDelegate.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation
import UIKit

protocol LoginViewDelegate: AnyObject {
    func sendLoginData(user: String, password: String) -> Void
}
