//
//  LoginBottonSheetViewController.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 15/06/25.
//

import Foundation
import UIKit

class LoginBottonSheetViewController: UIViewController {
    let loginView = LoginBottonSheetView()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.setupUI()
    }
    
    private func setupUI() {
        self.setupConstraints()
    }
    
    private func setupConstraints() {
        
    }
}
