//
//  HomeViewDelegate.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 17/06/25.
//

import Foundation
import UIKit

protocol HomeViewDelegate: AnyObject {
    func didTapProfileImage() -> Void
    func didTapLogoutButton() -> Void
}
