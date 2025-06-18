//
//  HomeViewController.swift
//  Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 17/06/25.
//

import Foundation
import UIKit

class HomeViewController: UIViewController {
    private let homeView: HomeView
    private let homeViewModel: HomeViewModel
    private weak var flowDelegate: HomeFlowDelegate?
    
    init(contentView: HomeView,
         flowDelegate: HomeFlowDelegate) {
        self.homeView = contentView
        self.flowDelegate = flowDelegate
        self.homeViewModel = HomeViewModel()
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() -> Void {
        super.viewDidLoad()
        
        self.setupUI()
        self.setupNavigationBar()
        self.checkForExistingData()
    }
    
    private func setupUI() -> Void {
        self.view.addSubview(self.homeView)
        self.navigationController?.navigationBar.isHidden = true
        
        self.homeView.viewDelegate = self
        self.buildHierarchy()
    }
    
    private func buildHierarchy() -> Void {
        setupContentViewToBounds(contentView: self.homeView)
    }
    
    private func setupNavigationBar() {
        let logoutButton = UIBarButtonItem(
            image: UIImage(named: "log-out"), style: UIBarButtonItem.Style.plain, target: self, action: #selector(logoutAction))
        
        logoutButton.tintColor = Colors.red_primary
        self.navigationItem.rightBarButtonItem = logoutButton
    }
    
    @objc private func logoutAction() -> Void {
        UserDefaultsManager.removeUser()
        self.flowDelegate?.logout()
    }
    
    private func checkForExistingData() -> Void {
        if UserDefaultsManager.loadUser() != nil {
            self.homeView.nameTextFiled.text = UserDefaultsManager.loadUserName()
        }
        
        if let imageProfile = UserDefaultsManager.loadProfileImage() {
            self.homeView.profileImage.image = imageProfile
        }
    }
}

extension HomeViewController: HomeViewDelegate {
    func didTapProfileImage() {
        self.selectProfileImage()
    }
    
    func didTapLogoutButton() {
        self.logoutAction()
    }
}

extension HomeViewController: UIImagePickerControllerDelegate, UINavigationControllerDelegate {
    private func selectProfileImage() {
        let imagePickerController = UIImagePickerController()
        imagePickerController.delegate = self
        imagePickerController.sourceType = .photoLibrary
        imagePickerController.allowsEditing = true
        present(imagePickerController, animated: true)
    }
    
    internal func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
        if let editedImage = info[.editedImage] as? UIImage {
            self.homeView.profileImage.image = editedImage
            UserDefaultsManager.saveProfileImage(image: editedImage)
        } else if let originalImage = info[.originalImage] as? UIImage {
            self.homeView.profileImage.image = originalImage
            UserDefaultsManager.saveProfileImage(image: originalImage)
        }
        
        self.dismiss(animated: true)
    }
    
    internal func imagePickerControllerDidCancel(_ picker: UIImagePickerController) {
        self.dismiss(animated:  true)
    }
}
