//
//  NewReceiptViewController.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 18/06/25.
//

import Foundation
import UIKit

class NewReceiptViewController: UIViewController {
    private let newReceiptView = NewReceiptView()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.setupUI()
//        self.setupAction()
    }
    
    private func setupUI() -> Void {
        self.view.backgroundColor = Colors.gray_100
        view.addSubview(newReceiptView)
        self.navigationController?.navigationBar.isHidden = true
        
        self.buildHierarchy()
    }
    
    private func buildHierarchy() -> Void {
        self.newReceiptView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            self.newReceiptView.topAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.topAnchor),
            self.newReceiptView.trailingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.trailingAnchor),
            self.newReceiptView.bottomAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.bottomAnchor),
            self.newReceiptView.leadingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.leadingAnchor),
        ])
    }
}
